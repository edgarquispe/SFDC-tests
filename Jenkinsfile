pipeline {
    agent any
    stages {
        stage('Commit') {
            steps {
                sh './gradlew compileJava compileTestJava'
            }
        }
        stage('UnitTest') {
            steps {
                sh './gradlew clean check'
            }
        }    
        stage('BehaveTests') {
            parallel {
                stage('Docker Chrome') {
                    steps {
                        sh '''./gradlew executeFeatures \
                        -Pusername=Cgonzales@freeorg02.com \
                        -Ppassword=P@sswOrd \
                        -Pbrowser=docker_chrome \
                        -PdockerUrl=http://172.21.18.99:4444/wd/hub
                        '''
                    }
                }
                stage('Docker Firefox') {
                    steps {
                        sh '''./gradlew executeFeatures \
                        -Pusername=Cgonzales@freeorg02.com \
                        -Ppassword=P@sswOrd \
                        -Pbrowser=docker_firefox \
                        -PdockerUrl=http://172.21.18.99:4443/wd/hub
                        '''
                    }
                }
            }
        }
    }
}
