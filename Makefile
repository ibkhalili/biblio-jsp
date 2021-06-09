NAME = run

DOCKER_MYSQL = my-own-mysql
DOCKER_PHPMYADMIN = my-own-phpmyadmin

MYSQL_PASSWORD = root

# must be an absolute path !
MYSQL_PATH = ~/Desktop/prjJava/mysql

# localhost:8081
PHPMYADMIN_PORT = 8081

all: $(NAME)

$(NAME):
	sudo docker run --name $(DOCKER_MYSQL) -v $(MYSQL_PATH):/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=$(MYSQL_PASSWORD) -d mysql:8.0.1
	sudo docker run --name $(DOCKER_PHPMYADMIN) -d --link $(DOCKER_MYSQL):db -p $(PHPMYADMIN_PORT):80 phpmyadmin/phpmyadmin

clean:
	sudo docker stop $(DOCKER_MYSQL)
	sudo docker rm $(DOCKER_MYSQL)
	sudo docker stop $(DOCKER_PHPMYADMIN)
	sudo docker rm $(DOCKER_PHPMYADMIN)

fclean: clean

re: fclean all

