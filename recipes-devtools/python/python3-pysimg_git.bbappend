
# Temporary fix until upstream fixes this

SRC_URI:remove ="git://github.com/dlenski/PySIMG.git;protocol=https;branch=master"
SRC_URI:append = "git://github.com/dlenski/PySIMG.git;protocol=https;branch=main"
