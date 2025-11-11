// SPDX-License-Identifier: UNLICENCED
pragma solidity ^0.8.2;

contract Student{

    //Structure
    struct  StudentStruct{
        string name;
        uint rollno;
    }

    //Array
    StudentStruct[] public studentarr;


    function addStudent(string memory name, uint rollno) public {
        for(uint i = 0; i<studentarr.length; i++){
            if(studentarr[i].rollno==rollno){
                revert("Student with this name already exists");
            }
        }
        studentarr.push(StudentStruct(name,rollno));
    }

    function getStudentLen() public view returns(uint){
        return studentarr.length;
    }

    function displayAll() public view returns(StudentStruct[] memory){
        return studentarr;
    }

    function getStudentByIndex(uint idx) public view returns(StudentStruct memory){
        require(idx<studentarr.length, "Index out of bound");
        return studentarr[idx];
    }

    //fallback
    fallback() external payable {
        //handle external function calls that are not there in contract 
        revert("");
    }

    receive() external payable {
        //handle ether sent by external user without data
     }

}