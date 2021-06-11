.PHONY: all AzulTerminal AzulInterfaceGraphique clean

all: AzulTerminal AzulInterfaceGraphique

AzulTerminal:
	cd AzulTerminal && mvn install
	cd AzulTerminal && mvn compile test assembly:single
	cp AzulTerminal/target/AzulTerminal-1.0-jar-with-dependencies.jar \
	   Azul-Terminal.jar

AzulInterfaceGraphique:
	cd AzulInterfaceGraphique && mvn install
	cd AzulInterfaceGraphique && mvn compile test assembly:single
	cp AzulInterfaceGraphique/target/AzulInterfaceGraphique-1.0-jar-with-dependencies.jar \
	   Azul-IG.jar

clean:
	cd AzulTerminal  && mvn clean
	cd AzulInterfaceGraphique  && mvn clean
