# Detemine if two IP addresses are in same network

To determine if two IP addresses are in the same network with a known subnet mask but unknown subnet, you can follow these steps:

1. Identify the subnet mask for the network in question. This will be a 32-bit binary value, where the bits that are set to 1 represent the network portion of the address, and the bits that are set to 0 represent the host portion of the address.

2. Convert the subnet mask to decimal notation (e.g. 255.255.255.0).

3. Compare the network portion of each IP address to the network portion of the subnet mask. To do this, perform a bitwise AND operation between the IP address and the subnet mask. This will give you the network address for each IP address.

4. If the network address for each IP address is the same, then they are on the same network. If the network addresses are different, then they are on different networks.

Here's an example:

Suppose you have two IP addresses, 192.168.1.100 and 192.168.1.200, and a subnet mask of 255.255.255.0. To determine if these two addresses are in the same network:

1. The subnet mask in binary is 11111111.11111111.11111111.00000000.

2. The subnet mask in decimal notation is 255.255.255.0.

3. Performing a bitwise AND operation between each IP address and the subnet mask gives the network address for each IP address:

```yaml
192.168.1.100: 11000000.10101000.00000001.01100100
255.255.255.0 : 11111111.11111111.11111111.00000000
Network address: 11000000.10101000.00000001.00000000 (192.168.1.0)

192.168.1.200: 11000000.10101000.00000001.11001000
255.255.255.0 : 11111111.11111111.11111111.00000000
Network address: 11000000.10101000.00000001.00000000 (192.168.1.0)
```

4. Both IP addresses have the same network address (192.168.1.0), so they are on the same network.

Note that this method assumes that both IP addresses are using the same subnet mask. If the subnet masks are different, then you would need to determine the network address for each IP address using its respective subnet mask, and compare those network addresses.