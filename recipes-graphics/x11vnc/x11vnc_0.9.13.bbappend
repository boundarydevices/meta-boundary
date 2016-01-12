# Complains about useless-rpath /usr/lib/
# This is harmless, lets skip this test until mainline fixes the issue
# gracefully.
INSANE_SKIP_${PN} += "useless-rpaths"
