pipeline {
    agent  any 
    stages {
        stage('Build') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew build'
            }
        }
        stage('Static Analysis') {
            steps {
                sh './gradlew check'
            }

        }
        stage('Docs') {
            steps {
                sh './gradlew javadoc'
            }

        }

    }
    
    post {
        always {
            archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
            junit 'build/test-results/**/*.xml'
        }
    }
}