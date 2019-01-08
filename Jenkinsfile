pipeline {
    agent any
    stages {
        stage('Commit') {
            steps {
                sh './gradlew compileJava compileTestJava'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew clean check'
                sh '''./gradlew executeFeatures
                -Pusername=Cgonzales@freeorg02.com
                -Ppassword=P@sswOrd
                -Pbrowser=docker_chrome
                -PdockerUrl=http://172.21.18.99:4444/wd/hub
                '''
                // publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'build/reports/tests/test/', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: 'HTML Report'])
                // junit 'build/test-results/test/*.xml'
            }
        }        
    }
}
