#!/bin/bash

REPO_NAME=`basename $(git remote show -n origin | grep Fetch | cut -d: -f2-) .git`

echo "Changing __REPO__ -> $REPO_NAME"

cp Jenkinsfile.original Jenkinsfile

perl -pi -e s/__REPO__/$REPO_NAME/g Jenkinsfile
