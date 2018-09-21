echo off

set cp=../lib/*;
set automation.prop=../cfg/automation.properties
set mobile.prop=../cfg/mobile.properties
set common.prop=../cfg/common.properties
set log=../cfg/log4j2.properties
set main=org.testng.TestNG
set suiteDefault=../suits/testng.xml
set suiteParam=%1
if defined suiteParam (
	set suite=%suiteParam%
) else (
	set suite=%suiteDefault%
)

java -cp %cp% -Dautomation.cfg=%automation.prop% -Dmobile.cfg=%mobile.prop% -Dcommon.cfg=%common.prop% -DLogj4=%log% %main%  %suite%