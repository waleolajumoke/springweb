pipeline {
    agent any

    // environment {
    //     // Java and Maven path if not globally available
    //     JAVA_HOME = '/usr/lib/jvm/java-17-openjdk' // Adjust to your installed version
    //     PATH = "${JAVA_HOME}/bin:${env.PATH}"
    // }

    tools {
        maven 'Maven 3.8.4' // Must be configured in Jenkins global tools
        jdk 'JDK 17'        // Must be configured in Jenkins global tools
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/waleolajumoke/springweb.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        // Optional stage to deploy
        // stage('Deploy') {
        //     steps {
        //         sh 'scp target/*.jar user@yourserver:/path/to/deploy/'
        //     }
        // }
    }

    post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
