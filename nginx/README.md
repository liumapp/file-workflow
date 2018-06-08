# docker-nginx-server
Using docker-compose to deploy Nginx server in Docker ,

## how to use

* pull nginx:1.13 by simply run 

		./build-image.sh

### config web 

update your /etc/hosts , and add 

		127.0.0.1 testa.com

		127.0.0.1 testb.com

### demo 

* run 

		docker-compose up -d

* open your browser , and visit http://testa.com and http://testb.com:5050,different page will be showed . 
		
* the output will be find in ./logs