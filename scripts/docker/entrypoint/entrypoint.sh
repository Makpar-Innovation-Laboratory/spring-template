#!/bin/bash
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
SCRIPT_NAME="entrypoint"
SCRIPT_DES=$''

wait-for-it $POSTGRES_HOST:$POSTGRES_PORT

java -cp app:app/lib/* com.odos.app.BackendApplication