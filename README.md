The CI/CD Pipeline

Automated build → test → dockerize → deploy for a Java Web App

This project demonstrates a complete CI/CD workflow for a Java web application, from the moment code is pushed to GitHub, to automated testing, Docker image creation, deployment, and post-deployment verification on a local VM.

🚀 Motivation

I built this project to gain hands-on experience with end-to-end CI/CD pipelines. In many real-world projects, manual build and deployment processes are error-prone and slow. Automating these steps:

Ensures code quality through automated tests and analysis.

Reduces manual intervention and human errors.

Speeds up the deployment process for new features.

Helps in understanding containerization (Docker), pipeline automation (Jenkins), and deployment strategies on a local VM.

Through this project, I learned how CI/CD pipelines enforce best practices, provide rapid feedback, and streamline software delivery.

🛠️ Tech Stack

Java (Spring Boot) – for building the web application, providing REST APIs and backend logic.

Maven – for project building, dependency management, and running unit tests.

SonarQube – for static code analysis to ensure code quality and maintainability.

Docker + Dockerfile – for containerizing the application to ensure it runs consistently across environments.

Jenkins (CI/CD pipelines) – to automate the build, test, and deployment processes.

Local VM – simulates a deployment environment where the Docker container runs, useful for testing deployments locally before production.

🔍 Features

Automatic build on code push – Every time a developer pushes code to GitHub, the CI pipeline automatically compiles the code and prepares it for testing.

Unit tests run before deployment – Ensures that the new code does not break existing functionality, enforcing software reliability.

Docker image creation – Builds a container image for the application, making deployment reproducible and environment-independent.

Deployment of Docker container – Deploys the containerized application to the target environment (local VM in this case).

Automated deployment on CI success – Only deploys when the CI pipeline successfully builds and passes all tests, maintaining production stability.

Separation of CI and CD pipelines – CI handles building and testing, while CD handles deployment and post-deployment verification, reflecting industry best practices.

⚙️ Architecture & Workflow

Here’s a step-by-step explanation of how the pipeline works:

Developer → Push to GitHub
  → CI Pipeline Triggered (Build + Test)
      → Build & Compile
      → Run Unit/Integration Tests
          → If Tests Pass → Build Docker Image
              → Push Docker Image to Registry

                  ↓

           CD Pipeline Triggered (on CI success)
              → Pull Docker Image from Registry
              → Deploy to Target Environment (local VM)
              → Verify Deployment (health checks, smoke tests)

Step-by-Step Explanation:

Developer Pushes Code to GitHub

This is the starting point. Any change in the main branch triggers the CI pipeline automatically via Jenkins webhooks.

CI Pipeline Triggered

Build & Compile: Jenkins pulls the latest code and compiles it using Maven.

Run Unit/Integration Tests: Ensures all tests pass; prevents broken code from moving forward.

Build Docker Image: If tests pass, Jenkins builds a Docker image of the app.

Push Docker Image to Registry: The image is pushed to Docker Hub or a private registry for use by the CD pipeline.

CD Pipeline Triggered (on CI success)

Pull Docker Image from Registry: CD pipeline pulls the latest tested image.

Deploy to Target Environment (local VM): The image is run as a container on a local VM, simulating a production environment.

Verify Deployment: Post-deployment verification ensures the app is running correctly. Health checks confirm the service is reachable, and smoke tests check key application functionality (e.g., API endpoints, web pages).
