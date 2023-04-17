pipeline {
    agent any
    tools {
        maven "maven_3_9_1"
        jdk "openjdk17"
    }
    stages {
        stage('Build') {
            steps {
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('Docker Image 製作與推送') {
            steps {
                withCredentials([usernamePassword(credentialsId: "docker-hub", passwordVariable: 'dockerPasswd', usernameVariable: 'dockerUser')]){
                    sh 'docker build -t u8921013/todo-list .'
                    sh 'docker login -u ${dockerUser} -p ${dockerPasswd}'
                    sh 'docker push u8921013/todo-list'
                }
            }
        }

//         stage('Build image') {
//               dockerImage = docker.build("monishavasu/my-react-app:latest")
//         }
    }

}