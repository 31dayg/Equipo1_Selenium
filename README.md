# Equipo1_Selenium

Members list:
Dayana 
Maricela
Juan Carlos
Eder Adrian

Documentation path: https://drive.google.com/drive/folders/1KTB_a0niycgRXx_HrmahxfSUpQeavMSB?usp=sharing

Pasos para trabajar en el repo:

- Clonar el repo: git clone url
- Checar los branches remotos disponibles: git branch -a
- Tomar nota del llamado "staging" pues en ese subiremos nuestros cambios:
- Crear un branch local de staging git checkout -b staging origin/master
- Pullear todos los cambios existentes en staging para asegurarnos estar con lo mas reciente: git pull origin staging 
--- Hacer los cambios correspondientes---
- Añadir todos los archivos que hayan sido modificados: git add -A
- Commitear todos los cambios: git commit -m "Cambios añadidos"
- Pushearlos a staging: git push origin staging