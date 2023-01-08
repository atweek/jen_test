pipeline {
    agent any
    parameters {
        choice(name: 'location', choices: ['New York City, United States', 'Amsterdam, the Netherlands', 'San Francisco, United States', 'Singapore','London, United Kingdom', 'Frankfurt, Germany', 'Toronto, Canada', 'Bangalore, India', 'Sydney, Australia'], description: 'A slug indicating the region where the Droplet will be created')

	choice(name: 'size', choices: ["1 CPU 1 GB","1 CPU 0.5 GB"], description: 'A slug indicating the size of the Droplet')
    }
    stages {
        stage('auth') {
            environment {
                TOKEN = credentials('36d3b42a-d868-4709-bb29-0be3986cc994')
	   }//env
            steps {
		script {
		    echo "account"
		    sh 'uname -a'
	            sh 'doctl auth init -t $TOKEN'
                    sh 'doctl account get'
                 }//script
	     }//steps
        }//stage
	stage('create VM') {
            steps {
                script {
			echo "create"
                 }//script
	     }//steps
        }//stage
    }//stages
}//end
