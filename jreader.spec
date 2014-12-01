%define _rpmdir ../
Summary:    JReader GUI RPM package  
Name:       JReader_GUI  
Version:    1.0  
Release:    1
License:    Commercial   
Group:      Application  
Buildroot:  buildroot
Vendor: JReader Corp.

%description  
JReader GUI for Linux x86_64

%install
echo ${RPM_BUILD_ROOT}
cp -rf *.war ${RPM_BUILD_ROOT}/%{_guitopdir}/tomcat/webapps/%{_buildname}.war

%files
%defattr(-,root,root)
/%{_guitopdir}/

%clean
[ "$RPM_BUILD_ROOT" != "/" ] && rm -rf "$RPM_BUILD_ROOT"

%post
if [ "$1" = "1" ];then
	echo "Initializing..."
fi