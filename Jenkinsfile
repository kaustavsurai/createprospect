pipeline {
    agent any
    tools{
        jdk 'JAVA_HOME'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                withMaven(maven: 'maven_3_5_2'){
                    bat 'mvn clean package'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy to Docker'){
            steps{
                bat 'docker login --username kaustavsurai --password Howrah-2019'
                bat 'docker image build -t springbootmongo .'
                bat 'docker tag springbootmongo kaustavsurai/springbootmongo'
                bat 'docker push kaustavsurai/springbootmongo'
            }
        }
        stage('Deploy to pcf') {
            steps {
                echo 'Deploying....'

                withCredentials([[$class:'UsernamePasswordMultiBinding',
                credentialsId: 'PCF_LOGIN',
                usernameVariable: 'kaustav541@gmail.com',
                passwordVariable: 'Howrah-2020']]) {
                    bat 'cf login -a https://api.run.pivotal.io -u kaustav541@gmail.com -p Howrah-2020'
                    bat 'cd\'
                    bat 'cf push createprospect --docker-image kaustavsurai/springbootmongo --random-route -i 1 -m 1024M -t 180 -k 3G'
                }
            }
        }
    }
}