To get a Git project into your build:

<p>
<b>1. Gradle:</b><br/>
Step 1. Add the JitPack repository to your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.tungthanh1497:TManisBase:1.0.0'
	}
</p>

<p>
<b>2. Maven:</b><br/>
Step 1. Add the JitPack repository to your build file

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.tungthanh1497</groupId>
	    <artifactId>TManisBase</artifactId>
	    <version>1.0.0</version>
	</dependency>
</p>

<p>
<b>3. Sbt:</b><br/>
Step 1. Add the JitPack repository to your  build.sbt at the end of resolvers:

 
    resolvers += "jitpack" at "https://jitpack.io"
        
    
Step 2. Add the dependency

	
	libraryDependencies += "com.github.tungthanh1497" % "TManisBase" % "1.0.0"	
</p>

<p>
<b>4. Leiningen:</b><br/>
Step 1. Add the JitPack repository to your project.clj at the end of repositories:

 
    :repositories [["jitpack" "https://jitpack.io"]]
        
    
Step 2. Add the dependency

	
	:dependencies [[com.github.tungthanh1497/TManisBase "1.0.0"]]	
</p>
