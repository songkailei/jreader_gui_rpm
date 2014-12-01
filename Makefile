# The following should be defined in environment variables
guitopdir=opt/jreader/web-portal
all: help

help:
	@echo "====================================================="
	@echo "Usage: "
	@echo "make execute            pack jreader_gui to rpm"
	@echo "====================================================="
	
	
execute:
	@echo "Begin packing..."
	$(call build_rpm)

define build_rpm
	mkdir -p buildroot;\
	mkdir -p buildroot/${guitopdir}/tomcat/;\
	buildname="jreader_gui";\
	echo "Start to build rpm for "$${buildname};\
	cp -rf /home/qli/song/apache-tomcat-6.0.43/* buildroot/${guitopdir}/tomcat/;\
	mvn clean;\
	mvn install;\
	rm -f .rpmmacros;\
	echo "%_topdir  `pwd`" > .rpmmacros;\
	echo "%_builddir  `pwd`/build" >> .rpmmacros;\
	HOME=`pwd`;rpmbuild -bb --define "_buildname `echo $${buildname}`" --define "_guitopdir `echo ${guitopdir}`" --buildroot "`pwd`/buildroot" jreader.spec;\
	cd .
endef