package com.study.spring.store.dto;

import java.util.List;

import lombok.Data;

@Data
public class StoreMenuDto {
	public Long id;
	public String name;
	public String addr;
	public List<MenuDto> menus;
}

//[
// {
//     "id": 4,
//     "name": "짱짜",
//     "addr": "마포",
//     "menus": []
// },
// {
//     "id": 3,
//     "name": "우리집",
//     "addr": "마포",
//     "menus": []
// },
// {
//     "id": 2,
//     "name": "칭니",
//     "addr": "구로",
//     "menus": [
//         {
//             "id": 3,
//             "name": "짜장면",
//             "price": 5000,
//             "store_id": 2
//         }
//     ]
// },
// {
//     "id": 1,
//     "name": "맛나",
//     "addr": "구로",
//     "menus": [
//         {
//             "id": 2,
//             "name": "떡볶이",
//             "price": 3000,
//             "store_id": 1
//         },
//         {
//             "id": 1,
//             "name": "라면",
//             "price": 5000,
//             "store_id": 1
//         }
//     ]
// }
//]
