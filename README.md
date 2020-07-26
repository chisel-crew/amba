# Amba

This project aims to build and provide as an opensource Chisel library the ARM Amba protocol bus, which incorporates:

1. APB
2. AHB
3. AXI4-Lite
4. AXI4 Memory Mapped
5. Axi4 Stream
6. AXI5 Chi

## Specifications

[All AMBA](https://developer.arm.com/documentation/search/5eec73ece24a5e02d07b2761)

[APB/AHB](https://developer.arm.com/documentation/ihi0024/c/preface)

[AXI4](https://developer.arm.com/documentation/ihi0022/e)

[AMBA5/CHI](https://documentation-service.arm.com/static/5f1061df0daa596235e7bfd6)

## Docker setup

You will need to install decent versions of [Verilator](https://www.veripool.org/) and [Yosys](http://www.clifford.at/yosys/) to work with this project. Also you need to have [sbt](https://www.scala-sbt.org/) installed

You may use a Docker image with all prebuilt dependencies to avoid installing all dependencies. 

1. Install the latest [Docker](https://docs.docker.com/engine/install/)
2. Execute the following command: `docker run -it tampler/chisel-crew-base:11`
This will pull the docker image and will open the shell, where you can clone the project and run simulation and synthesis


## Resources 
1. [Chisel Home](https://www.chisel-lang.org/)
2. [Wiki](https://github.com/freechipsproject/chisel3/wiki)
3. [Cookbook](https://github.com/freechipsproject/chisel3/wiki/Cookbook)
3. [Advanced Chisel](https://inst.eecs.berkeley.edu/~cs250/sp17/handouts/advanced-chisel.pdf)
