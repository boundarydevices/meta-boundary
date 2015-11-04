killem() { /etc/init.d/app stop ; }
startem() { /etc/init.d/app start ; }
if [ -e /app/app.profile ]; then
        . /app/app.profile
fi
