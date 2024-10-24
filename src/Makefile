.PHONY: libsysinfo/libsysinfo.so

MODULES=sysInfo cpuInfo pciInfo usbInfo
HEADERS=$(MODULES:%=%.h)

LIBSYSINFO_PATH=libsysinfo
LIBSYSINFOSO_PATH=$(LIBSYSINFO_PATH)/libsysinfo.so
MYPROJECT=test

all: $(HEADERS) $(MYPROJECT).class $(LIBSYSINFOSO_PATH)

$(MYPROJECT).class: $(MYPROJECT).java $(LIBSYSINFOSO_PATH)
	javac $<

$(HEADERS): %.h: %.java
	javac -h $<

$(LIBSYSINFOSO_PATH):
	$(MAKE) -C $(LIBSYSINFO_PATH)

