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
                    sh 'docker build --build-arg JAR_FILE=target/todo-list-0.0.2-SNAPSHOT.jar -t u8921013/todo-list .'
                    sh 'docker login -u ${dockerUser} -p ${dockerPasswd}'
                    sh 'docker push u8921013/todo-list'
                }
            }
        }
        stage("部署到機器上"){
            steps{
                sshPublisher(publishers: [sshPublisherDesc(configName: '203.66.14.147', sshCredentials: [encryptedPassphrase: '{AQAAABAAAAAg1HLl8nXIIBXLWhpX2ie6bm/FZW5sgMPTOOnPy5MV769ycKFbJEccZ19vbw2GD6m+}', key: '', keyPath: '', username: 'root'], transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '/opt/docker-todo/deploy.sh', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: true)])
            }
        }

//         stage('Build image') {
//               dockerImage = docker.build("monishavasu/my-react-app:latest")
//         }
    }

}