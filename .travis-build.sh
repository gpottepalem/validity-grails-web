#!/usr/bin/env bash
set -e
echo "Assembling....."
./gradlew -Dgrails.env=test clean assemble --stacktrace
EXIT_STATUS = 0
exit $EXIT_STATUS
