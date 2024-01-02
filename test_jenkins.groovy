import groovy.sql.Sql

def username = 'root'

pipeline {
    agent any

    stages {
        stage('Preparation') {
            steps {
                echo 'EJECUTANDO DDL'
            }
        }
    
        stage('Execute SQL Script') {
            steps { 

                withCredentials([string(credentialsId: '1', variable: 'DB_PASSWORD')]) {
                    sh """
                    mysql -u ${username} -p '$DB_PASSWORD' -h host.docker.internal -P 3306 < ./DDL_CREATE_TABLE.sql
                    """
                }
            }
        }
    }
}