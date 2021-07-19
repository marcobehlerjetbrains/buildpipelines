import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.dockerSupport
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.dockerRegistry
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.2"

project {

    buildType(DeployAuthServer)
    buildType(CompileCalcServer)
    buildType(BuildDockerImageCalculatorServer)
    buildType(DeployCalcServer)
    buildType(Build)
    buildType(BuildDockerImageAuthServer)

    features {
        dockerRegistry {
            id = "PROJECT_EXT_3"
            name = "Docker Registry"
            url = "https://docker.io"
            userName = "marcobehler"
            password = "credentialsJSON:ad7661a2-9539-44d6-9ac0-b37a4e48e01f"
        }
    }
}

object Build : BuildType({
    name = "Compile Auth Server"

    artifactRules = "authorization-service/target/*.jar => target"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            goals = "clean package"
            pomLocation = "authorization-service/pom.xml"
        }
    }
})

object BuildDockerImageAuthServer : BuildType({
    name = "Build Docker Image (Auth Server)"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        dockerCommand {
            commandType = build {
                source = file {
                    path = "authorization-service/Dockerfile"
                }
                namesAndTags = "marcobehler/buildpipelines:auth-%build.number%"
            }
        }
        dockerCommand {
            commandType = push {
                namesAndTags = "marcobehler/buildpipelines:auth-%build.number%"
            }
        }
    }

    features {
        dockerSupport {
            loginToRegistry = on {
                dockerRegistryId = "PROJECT_EXT_3"
            }
        }
    }

    dependencies {
        dependency(Build) {
            snapshot {
            }

            artifacts {
                artifactRules = "target/*.jar => authorization-service/target"
            }
        }
    }
})

object BuildDockerImageCalculatorServer : BuildType({
    name = "Build Docker Image (CalculatorServer)"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        dockerCommand {
            commandType = build {
                source = file {
                    path = "calculator-service/Dockerfile"
                }
                namesAndTags = "marcobehler/buildpipelines:calculator-%build.number%"
            }
        }
        dockerCommand {
            commandType = push {
                namesAndTags = "marcobehler/buildpipelines:calculator-%build.number%"
            }
        }
    }

    features {
        dockerSupport {
            loginToRegistry = on {
                dockerRegistryId = "PROJECT_EXT_3"
            }
        }
    }

    dependencies {
        dependency(CompileCalcServer) {
            snapshot {
            }

            artifacts {
                artifactRules = "target/*.jar => calculator-service/target"
            }
        }
    }
})

object CompileCalcServer : BuildType({
    name = "Compile Calc Server"

    artifactRules = "calculator-service/target/*.jar => target"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            goals = "clean package"
            pomLocation = "calculator-service/pom.xml"
        }
    }
})

object DeployAuthServer : BuildType({
    name = "Deploy Auth Server"

    artifactRules = "authorization-service/target/*.jar => target"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            scriptContent = """echo "Deploying Auth Service...""""
        }
    }

    triggers {
        vcs {
        }
    }

    dependencies {
        snapshot(BuildDockerImageAuthServer) {
        }
    }
})

object DeployCalcServer : BuildType({
    name = "Deploy Calc Server"

    artifactRules = "authorization-service/target/*.jar => target"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            scriptContent = """echo "Deploying Calc Service...""""
        }
    }

    triggers {
        vcs {
        }
    }

    dependencies {
        snapshot(BuildDockerImageCalculatorServer) {
        }
    }
})
