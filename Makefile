BUILD:
	docker image build -t tejaswayadav/secure-docker-application:oauth .

PUSH:
	docker image push tejaswayadav/secure-docker-application:oauth
