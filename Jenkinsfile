pipeline {
    agent any
    
    stages {
        stage('Git Checkout') {
            steps {
                print ("Get source code from Github")
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/shreyaanjali/First_Sprint_BOOT_WEB_application.git']])
            
              
            }
        }
        
        stage('Build project') {
            steps {
                // Building our project using Maven command   
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('static code Analysis') {
             steps {
            withSonarQubeEnv(installationName: 'SonarQube-API') {
            // Perform code analysis with SonarQube
            sh 'mvn sonar:sonar'
              }
           }
        
         }

        stage('Quality gate status'){
             steps {
                 script{
                    waitforQualityGate abortPipeline: false, credentialsId: 'Sonar-API'
                 }
             }
         }




     stage('Build docker image')  {
        steps {
            sh 'docker build -t anjalishreya1/ciautomationimage:latest .'
                
            
            }

        }
     
     stage('Push image to docker hub') {
         steps {
             script {
                 withCredentials([usernamePassword(credentialsId: 'Dockercred', passwordVariable: 'Password', usernameVariable: 'AnjaliShreya')]) {
                 sh ' docker login -u ${AnjaliShreya} -p ${Password}' 
                 sh ' docker push anjalishreya1/ciautomationimage:latest'
                    }
                }
            }
        }
    }
}
