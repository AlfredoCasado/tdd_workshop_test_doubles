Software necesario:

	- jdk java
	- gradle 

No es imprescindible pero como recomendación utilizar gvm para instalar gradle (http://gvmtool.net/)

Para ejecutar todos los test de un proyecto gradle simplemente: 

	- gradle test

Para ejecutar un sólo test:

	- gradle -Dtest.single=MarsRoverControlUnitSpec

nota1: Como recomendación usar la opción --daemon para que deje una jvm arrancada en segundo plano, esto acelerá bastante la ejecución de los test.

nota2: Un problema de gradle es que los resultados de los test en consola se muestran bastante cutres. He añadido al build.gradle una pequeña funcionalidad para que si algún test ejecutado contiene errores abra automaticamente un navegador con el informe para el test fallido donde ya se puede ver el error en condiciones.


