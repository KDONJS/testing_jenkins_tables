import groovy.sql.Sql

def username = 'root'

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
                    script {
                        def dbUrl = 'jdbc:mysql://localhost:3306/productosplazavea'
                        def user = ${username}
                        def password = DB_PASSWORD
                        def sql = Sql.newInstance(dbUrl, user, password, 'com.mysql.cj.jdbc.Driver')

                        sql.execute('CREATE TABLE empleados (id INT PRIMARY KEY, nombre VARCHAR(100), edad INT, departamento VARCHAR(100))')
                    }
                }
            }
        }
    }
}