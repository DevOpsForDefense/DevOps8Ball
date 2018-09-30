pipeline {
    agent  any 
    stages {
        stage('Build') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew build -x checkstyleMain -x checkstyleTest -x spotbugsMain -x spotbugsTest'
                step( [ $class: 'JacocoPublisher' ] )
            }
        }
        stage('Static Analysis') {
            steps {
                sh './gradlew check'
                step([$class: 'hudson.plugins.checkstyle.CheckStylePublisher', 
                     pattern: 'build/reports/checkstyle/main.xml', 
                     unstableTotalAll:'0',unhealthy:'100', healthy:'100'])
                step([$class: 'FindBugsPublisher', pattern: 'build/reports/spotbugs/main.xml', unstableTotalAll:'0'])
            }

        }
        stage('Docs') {
            steps {
                sh './gradlew javadoc'
            }

        }
        stage('Acceptance Test') {
            steps {
                sh './gradlew cucumber'
            }

        }

    }
    
    post {
        always {
            archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
            junit 'build/test-results/**/*.xml'
            
            // publish JavaDocs
		    publishHTML (target: [
		        allowMissing: false,
		        alwaysLinkToLastBuild: false,
		        keepAll: true,
		        reportDir: 'build/docs/javadoc/',
		        reportFiles: 'allclasses-noframe.html',
		        reportName: "JavaDocs"
		    ])
		    
		    // publish Test Coverage
		    publishHTML (target: [
		        allowMissing: false,
		        alwaysLinkToLastBuild: false,
		        keepAll: true,
		        reportDir: 'build/reports/jacoco/test/html/',
		        reportFiles: 'index.html',
		        reportName: "Coverage Reports"
		    ])
        }
    }
}