BUILD:
	docker image build -t tejaswayadav/secure-docker-application:ouath1.0 .

PUSH:
	docker image push tejaswayadav/secure-docker-application:ouath1.0
