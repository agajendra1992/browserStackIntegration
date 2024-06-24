pipeline {
    agent any

    stages {
        stage('Get Source Code') {
            steps {
                git credentialsId: '221c1257-245e-484b-ab0d-8a146d8b0348', url: 'https://github.com/agajendra1992/browserStackIntegration.git'
                echo 'Hello World'
            }
        }
    stage('Build Code') {
            steps {
                bat script: 'mvn compile'
            }
        }
    stage('Run Test') {
            steps {
                bat script: 'mvn clean test'
            }
        }
    stage('Publish Result') {
            steps {
               publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: '', reportFiles: 'target/Reports/AutomationReport.html', reportName: 'Automation_Report', reportTitles: '', useWrapperFileDirectly: true])
            }
        }    
    }
}
