@echo off
set commitMessage = %1

call gitAdd
call gitCommit %commitMessage%
call gitPush