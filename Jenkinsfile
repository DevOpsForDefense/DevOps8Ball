pipeline {
    agent  any 
    stages {
        stage('Build') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew build'
            }
        }
        stage('Docs') {
            steps {
                sh './gradlew javadoc'
            }

        }

    }
}