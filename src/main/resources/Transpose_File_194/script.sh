declare -A words
File="file.txt"
while read line
do
  stringarray=(${line})
  for word in "${stringarray[@]}"
  do
    # The following sed command will remove the trailing newline from the variable
    word=$(echo "$word" | sed 's/\n$//g')
    # if word is not empty
    if [ -n "$word" ]
    then
      #echo ".$word."
      # if array contains word
      if [ "${words["$word"]}" ]
      then
        # increment by 1
        temp=words["$word"]
        words["$word"]=$(($temp + 1))
      else
        # else put 1
        words["$word"]=1
      fi
    fi
  done
done < "$File"

for wd in "${!words[@]}"
do
  echo "$wd ${words[$wd]}"
done