# file-workflow
Display the file upload workflow with iView

## how to use

* run ./build-image.sh

* run docker.compose up -d

* wait a second , and open your browser visit http://localhost

* you can find the result here : 

	![1.jpg](https://github.com/liumapp/file-workflow/blob/master/pic/1.jpg)

	![2.jpg](https://github.com/liumapp/file-workflow/blob/master/pic/2.jpg)

	![3.jpg](https://github.com/liumapp/file-workflow/blob/master/pic/3.jpg)

	![4.jpg](https://github.com/liumapp/file-workflow/blob/master/pic/4.jpg)

* and docker service is : 

	![5.jpg](https://github.com/liumapp/file-workflow/blob/master/pic/5.jpg)	

## attention

* if you want to rebuilt flow-ui , plz run :

		cd flow-ui

		cp -r ./dist/* ../nginx/www/flowui	

	to make nginx in docker get the source . 

* if you want to rebuilt flow-service , plz run :
	
		./rm-image.sh

	than 	

		./build-image.sh			

