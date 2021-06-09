NAME = run

DOCKER_MYSQL = my-own-mysql
DOCKER_PHPMYADMIN = my-own-phpmyadmin
DOCKER_TOMCAT = my-own-tomcat
DOCKER_APP = my-own-app
BIBLIO_APP = biblio-app

MYSQL_PASSWORD = root

# must be an absolute path !
MYSQL_PATH = ~/Desktop/prjJava/mysql

# localhost:8081
PHPMYADMIN_PORT = 8081

all: $(NAME)

$(NAME):
	sudo docker run --name $(DOCKER_MYSQL) -v $(MYSQL_PATH):/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=$(MYSQL_PASSWORD) -d mysql:8.0.1
	sudo docker run --name $(DOCKER_PHPMYADMIN) -d --link $(DOCKER_MYSQL):db -p $(PHPMYADMIN_PORT):80 phpmyadmin/phpmyadmin

web:
	jar -cvf biblio.war *
	docker build -t $(BIBLIO_APP) .
	docker run --name $(DOCKER_APP) -p 8080:8080 $(BIBLIO_APP)

clean:
	sudo docker stop $(DOCKER_APP)
	sudo docker rm $(DOCKER_APP)
	sudo docker stop $(DOCKER_MYSQL)
	sudo docker rm $(DOCKER_MYSQL)
	sudo docker stop $(DOCKER_PHPMYADMIN)
	sudo docker rm $(DOCKER_PHPMYADMIN)

fclean: clean

re: fclean all

