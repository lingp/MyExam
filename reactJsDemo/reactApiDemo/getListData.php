<?php
header('Content-Type:application/json;charset=utf-8');
echo file_get_contents('./data/todo.json');