pipeline {
    agent any
    tools {
        maven "maven_3_9_1"
        jdk "openjdk17"
    }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
//                     git branch: 'master', url: 'https://github.com/u8921013/todo-list.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package -X"
                //sh "docker build -t u8921013/todo-list ."
                //sh "docker push u8921013/todo-list"
                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }

//         stage('Build image') {
//               dockerImage = docker.build("monishavasu/my-react-app:latest")
//         }
    }

}