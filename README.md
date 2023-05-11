## Install FLY.IO (windows)
```
iwr https://fly.io/install.ps1 -useb | iex
export FLYCTL_INSTALL="/home/leo/.fly"
export PATH="$FLYCTL_INSTALL/bin:$PATH"
```

## Install FLY.IO (linux)
```
curl -L https://fly.io/install.sh | sh
export FLYCTL_INSTALL="/home/leo/.fly"
export PATH="$FLYCTL_INSTALL/bin:$PATH"
```

## DEPLOY
```
ejecutar el task build de gralde
flyctl deploy
```

## RESTART
```
flyctl apps restart nameless-leaf-2280
```