Software necesario:

	- ruby
	- rspec gem (gem install rspec)

No es imprescindible pero como recomendación utilizar rvm para instalar ruby (https://rvm.io/)

Para ejecutar todos los test de un proyecto ruby simplemente: 

	- rspec spec

Para ejecutar un sólo fichero de test:

	- rspec spec/mars_rover_control_unit_spec.rb

Para ejecutar un sólo test:

  - rspec spec/mars_rover_control_unit_spec.rb:4 (Sustituye 4 por el número de línea en el que empieza el test)
