import groovy.sql.Sql

def username = 'Jenkins'

pipeline {
    agent any

    stages {
        stage('Preparation') {
            steps {
                echo 'EJECUTANDO DDL'

                //SSSbat "mysql -u ${username} -p '%DB_PASSWORD%' -h localhost \"SHOW DATABASES;\""
            }
        }
    
        stage('Execute SQL Script') {
            steps { 

                withCredentials([string(credentialsId: '1', variable: 'DB_PASSWORD')]) {

                    // bat "mysql -u ${username} -p '%DB_PASSWORD%' -h localhost productosplazavea < DDL_CREATE_TABLE.sql"

                    bat "ls"

                }
            }
        }
    }
}