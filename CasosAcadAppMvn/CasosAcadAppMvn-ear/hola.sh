#!/bin/bash
echo "iniciando la configuración "
d=$PWD
cp $d/target/CasosAcadAppMvn-ear-1.0-SNAPSHOT.ear composeTPI/glassfish/CasosAcadAppMvn-ear-1.0-SNAPSHOT.ear
cd $d/composeTPI
docker-compose build 
if [ $? -eq 0 ]; then
			echo "Compilación completa. deteniendo el servidor para relanzarlo. \n Espere...." &&\
			bash shutdown.sh &&\			
			echo "Los servicios se han detenido correctamente. Re-lanzando el servidor.\n Espere" &&\
			bash startup.sh &&\			
			echo "Los servicios se han lanzado correctamente."

		else
			echo "Error al compilar las imágenes del docker-compose. No se ha modificado El servidor."
		fi
cd $d
