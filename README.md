# InventStar
Proyecto grupal del curso LP2 de la PUCP dictado en el 2023-1. InventStar es un sistema completo de gestión de inventario, promociones, clientes y control de calidad en tiempo real, diseñado específicamente para cafeterías como Starbucks.

## Guía

Para trabajar con tu equipo, puedes seguir la siguiente estrategia de ramificación con Git:

- Cada miembro del equipo debe clonar el repositorio a su máquina local utilizando `git clone https://github.com/alvax64/InventStar`.
- Cuando un miembro del equipo empiece a trabajar en una nueva característica o tarea, debe crear una nueva rama desde la rama principal (master o main). Esto se puede hacer con el comando `git checkout -b feature_branch`.
- Cuando la característica esté terminada, el miembro del equipo debe hacer commit de sus cambios (`git add .` y `git commit -m "Commit message"`) y luego hacer push de su rama al repositorio de GitHub (`git push origin feature_branch`).
- Posteriormente, el miembro del equipo debe abrir un Pull Request en GitHub. Aquí, todo el equipo puede revisar el código y hacer comentarios.
- Cuando todos estén de acuerdo, la rama de la característica se puede fusionar con la rama principal.

Esta estrategia asegura que la rama principal siempre tenga un código funcional y ayuda a gestionar el trabajo de múltiples personas en el mismo proyecto. Recuerda que el uso eficiente de Git y GitHub puede requerir un poco de práctica, pero es una habilidad valiosa para cualquier equipo de desarrollo de

### Para abrir un pull request en GitHub:

1. Navega a la página principal de tu repositorio en GitHub.
2. Haz clic en la pestaña "Pull requests".
3. Haz clic en el botón verde "New pull request".
4. Selecciona la rama base a la cual quieres hacer merge (usualmente `master` o `main`) y la rama de la característica que quieres hacer merge a la rama base.
5. Haz clic en el botón verde "Create pull request".
6. Agrega cualquier comentario adicional que te gustaría incluir, como la descripción del cambio que has realizado.
7. Haz clic en "Create pull request".

Una vez que se haya creado el pull request, los miembros de tu equipo pueden revisarlo, hacer comentarios, solicitar cambios o aprobarlo.

### Para fusionar una rama de característica con la rama principal:

Primero, es necesario que te asegures que la rama de la característica esté actualizada con la rama principal. Esto se hace para prevenir problemas de compatibilidad con otras características que se han desarrollado en paralelo. Para hacer esto:

1. Asegúrate de que estás en la rama de la característica (`git checkout feature_branch`).
2. Haz pull de los cambios más recientes de la rama principal (`git pull origin main` o `git pull origin master`, según corresponda).
3. Si hay conflictos de merge, resuélvelos. GitHub te indicará en qué archivos se encuentran los conflictos. Abre esos archivos y verás las diferencias entre las ramas en formato de conflicto de Git. Elimina las líneas que no necesitas y conserva las que quieres mantener, luego guarda los cambios.
4. Una vez que hayas resuelto los conflictos, añade los archivos (`git add .`), haz un commit (`git commit -m "Resolved merge conflicts"`), y luego haz un push a la rama de la característica (`git push origin feature_branch`).

Ahora, tu rama de característica está actualizada con la rama principal y los conflictos de merge se han resuelto. Ya estás listo para hacer el merge de la rama de característica a la rama principal. Para hacer esto:

1. Ve a la página del pull request en GitHub.
2. Haz clic en el botón verde "Merge pull request".
3. Haz clic en "Confirm merge".

Recuerda que es importante tener una buena comunicación con tu equipo para que todos estén al tanto de qué se está trabajando en cada rama. Esto puede ayudar a minimizar los conflictos de merge.

## Versionado semántico (o SemVer)

Este sistema ha sido ampliamente adoptado en la comunidad de desarrollo de software para llevar un control de versiones claro y consistente. Aquí te dejo una guía sobre cómo podrías aplicarlo:

El versionado semántico se compone de tres números separados por puntos de la forma X.Y.Z, donde:

- X es el número de versión mayor (major version)
- Y es el número de versión menor (minor version)
- Z es el número de corrección (patch version)

La lógica detrás del uso de estos tres números es la siguiente:

1. **Versión Mayor (X):** Incrementa este número cuando hagas cambios incompatibles en la API, es decir, cuando realices cambios que hagan que los usuarios deban modificar su código para poder usar la nueva versión de tu software.

2. **Versión Menor (Y):** Incrementa este número cuando añadas funcionalidades que sean compatibles hacia atrás. Esto significa que, si los usuarios actualizan tu software, no tendrán que hacer cambios en su código, pero tendrán nuevas características disponibles.

3. **Versión de Corrección (Z):** Incrementa este número cuando hagas correcciones de errores que sean compatibles hacia atrás. Esto significa que, si los usuarios actualizan tu software, no obtendrán nuevas características, pero su experiencia será más estable debido a las correcciones de errores.

Un ejemplo de cómo podrías usar el versionado semántico en tu control de versiones podría ser el siguiente:

- Comienzas el desarrollo de tu software con la versión 0.1.0. Esta versión tiene funcionalidades muy limitadas y aún está en desarrollo.
- Desarrollas una nueva característica y la añades a tu software. Ahora actualizas tu versión a 0.2.0.
- Descubres un error en la nueva característica que acabas de añadir y lo corriges. Ahora actualizas tu versión a 0.2.1.
- Después de varias iteraciones, sientes que tu software está listo para ser lanzado oficialmente. Lo actualizas a la versión 1.0.0.
- Después del lanzamiento, añades una nueva característica sin romper la compatibilidad hacia atrás. Actualizas tu software a la versión 1.1.0.
- Descubres un error en tu software y lo corriges. Actualizas tu software a la versión 1.1.1.
- Haces cambios significativos que rompen la compatibilidad hacia atrás. Actualizas tu software a la versión 2.0.0.

Por último, recuerda que el versionado semántico es una convención y, aunque es ampliamente adoptado, no todos los proyectos lo utilizan. Debes adaptarlo a las necesidades y el flujo de trabajo de tu propio proyecto.
