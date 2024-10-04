package com.ecommerce.user_service.mapper;

import com.ecommerce.user_service.dto.AddressDTO;
import com.ecommerce.user_service.dto.UserDTO;
import com.ecommerce.user_service.entity.Address;
import com.ecommerce.user_service.entity.Users;

public class UserDtoMapper {

    public static Users DtoToEntity(UserDTO userDTO){
        Users user=new Users();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());
        user.setAddress(toAddress(userDTO.getAddress()));
        return user;
    }
    public static UserDTO entityToDto(Users users){
        UserDTO userDTO=new UserDTO();
        userDTO.setId(users.getId());
        userDTO.setFirstName(users.getFirstName());
        userDTO.setLastName(users.getLastName());
        userDTO.setPhoneNumber(users.getPhoneNumber());
        userDTO.setEmail(users.getEmail());
        userDTO.setAddress(toAddressDto(users.getAddress()));
        return userDTO;
    }
    public static AddressDTO toAddressDto(Address address){
        AddressDTO addressDTO=new AddressDTO();
        addressDTO.setAddressLine1(address.getAddressLine1());
        addressDTO.setAddressLine2(address.addressLine2);
        addressDTO.setAddressLine3(address.addressLine3);
        addressDTO.setPin(address.getPin());
        return addressDTO;
    }
    public static Address toAddress(AddressDTO addressDTO){
        Address address=new Address();
        address.setAddressLine1(addressDTO.getAddressLine1());
        address.setAddressLine2(addressDTO.addressLine2);
        address.setAddressLine3(addressDTO.addressLine3);
        address.setPin(addressDTO.getPin());
        return address;
    }
}