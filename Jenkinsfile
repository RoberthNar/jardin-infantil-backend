@Library('ceiba-jenkins-library@master') _
pipeline{
	// any -> tomaria slave 5 u 8
	// Para mobile se debe especificar el slave -> {label 'Slave_Mac'}
	// Para proyectos de arus se debe tomar el slave 6 o 7 -> {label 'Slave6'} o {label 'Slave7'}
    agent {
          label 'Slave_Induccion'
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
    }

    environment {
        AMBIENTE_DEV = 'dev'
        NOMBRE_IMAGEN_DOKER = 'jardin-infantil-backend'
        NOMBRE_DB_DOKER = 'jardin-infantil-db'
        PROJECT_PATH_BACK = 'jardin-infantil-backend'
    }

    tools {
        jdk 'JDK11_Centos'
    }

    // Parametros disponibles en jenkins
     /*parameters{
            string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
            text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
            booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
            choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
            password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a passwor')
     }*/

    stages{
        stage('Checkout') {
                    steps {
                        echo '------------>Checkout desde Git Microservicio<------------'
                        checkout scm
                    }
        }

        stage('Compilacion y Test Unitarios'){
            steps{
                echo "------------>IP Servidor<------------"
                sh 'hostname -I'

                echo "------------>Clean Tests<------------"

                sh 'chmod +x ./microservicio/gradlew'
                sh './microservicio/gradlew --b ./microservicio/build.gradle clean'

                echo "------------>compile & Unit Tests<------------"

                sh 'chmod +x ./microservicio/gradlew'
                sh './microservicio/gradlew --b ./microservicio/build.gradle test'
            }
        }
		
		stage('Static Code Analysis') {
			steps{

                echo '------------>Análisis de código estático<------------'

				sonarqubeMasQualityGatesP(
                    sonarKey:'co.com.ceiba:adn:jardin-infantil-backend.roberth.narvaez',
                    sonarName:'''"CeibaADN-JardinInfantil(roberth.narvaez)"''',
                    sonarPathProperties:'./sonar-project.properties'
                )
			}
		}

        stage('Build DEV') {
            steps {
                sh "docker build -t ${NOMBRE_IMAGEN_DOKER}-${AMBIENTE_DEV} . --build-arg AMBIENTE=${AMBIENTE_DEV}"
            }
        }
    }

    post {
        failure {
            mail(
                to: 'roberth.narvaez@ceiba.com.co',
                body:"Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/nPlease go to ${env.BUILD_URL} and verify the build",
                subject: "ERROR CI: ${env.JOB_NAME}"
            )
            updateGitlabCommitStatus name: 'IC Jenkins', state: 'failed'
        }
        success {
            updateGitlabCommitStatus name: 'IC Jenkins', state: 'success'
        }
    }
}
