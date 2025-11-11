// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.13;

contract Bank{

    uint256 balance=0;
    address public accOwner;

    constructor(){
        accOwner=msg.sender;

    }

    // Deposit
    function Deposit()public payable {
        require(accOwner==msg.sender,"You are not the owner");
        require(msg.value>0, "Amount should be greater than 0!");
        balance+=msg.value;
    }

    //Withdraw
    function Withdraw() public payable {
        require(accOwner==msg.sender,"You are not the owner");
        require(msg.value>0, "Amount should be greater than 0!");
        require(msg.value<balance, "Insufficient money!");
        balance-=msg.value;
    }

    //ShowBalance
    function ShowBalance() public view returns(uint256){
        require(accOwner==msg.sender,"You are not the owner");
        return balance;
    }
}