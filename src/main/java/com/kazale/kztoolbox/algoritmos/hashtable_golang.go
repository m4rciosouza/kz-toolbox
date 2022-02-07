package hashtablell

import (
	"fmt"
)

type Node struct {
	Key   string
	Value int
	Next  *Node
}

type LList struct {
	Head *Node
}

func (ll *LList) Add(key string, value int) {
	newNode := Node{Key: key, Value: value}
	if ll.Head == nil {
		ll.Head = &newNode
	} else {
		node := ll.Head
		for node.Next != nil {
			node = node.Next
		}
		node.Next = &newNode
	}
}

func (ll LList) Get(key string) (int, bool) {
	node := ll.Head
	for node != nil {
		if node.Key == key {
			return node.Value, true
		}
		node = node.Next
	}
	return 0, false
}

func (ll *LList) Delete(key string) bool {
	node := ll.Head
	var prev *Node

	// If head node itself holds the key to be deleted
	if node != nil && node.Key == key {
		node = node.Next
		return true
	}

	// Search for the key to be deleted, keep track of, the previous node as we need to change node.next
	for node != nil && node.Key != key {
		prev = node
		node = node.Next
	}

	if node == nil || prev == nil {
		return false
	}

	prev.Next = node.Next
	return true
}

// hash table implementation

type HashTableLL struct {
	Values   []LList
	Capacity int
	Size     int
}

func (ht HashTableLL) Hash(key string) int {
	index := 0
	for _, c := range key {
		index += int(c) // basic version, would collide "marcio" with "oicram"
	}
	return index % ht.Capacity // tends to limit the array size by its value, try 3, 599...
}

func (ht *HashTableLL) ReHash() {
	currValues := ht.Values
	ht.Capacity = nextPrime(ht.Capacity * 2)
	fmt.Printf("New Capacity = %d\n", ht.Capacity)
	ht.Size = 0
	ht.Values = make([]LList, ht.Capacity)
	for i := 0; i < len(currValues); i++ {
		node := currValues[i].Head
		for node != nil {
			ht.Add(node.Key, node.Value)
			node = node.Next
		}
	}
}

func (ht *HashTableLL) Add(key string, value int) {
	if float32(ht.Size/ht.Capacity) > 0.75 { // rehash when load factor over 75%
		ht.ReHash()
	}
	index := ht.Hash(key)
	node := ht.Values[index].Head
	for node != nil {
		if node.Key == key {
			node.Value = value
			return
		}
		node = node.Next
	}
	ht.Values[index].Add(key, value)
	ht.Size++
}

func (ht *HashTableLL) Delete(key string) {
	index := ht.Hash(key)
	deleted := ht.Values[index].Delete(key)
	if deleted {
		ht.Size--
	}
}

func (ht HashTableLL) Get(key string) int {
	index := ht.Hash(key)
	v, exists := ht.Values[index].Get(key)
	if !exists {
		return -1
	}
	//fmt.Printf("Got %s from index %d\n", key, index)
	return v
}

func (ht HashTableLL) ToString() {
	maxDepth := -1
	for i := 0; i < len(ht.Values); i++ {
		if ht.Values[i].Head != nil {
			fmt.Printf("Bucket %d contains:\n", i)
			node := ht.Values[i].Head
			numBucket := 0
			for node != nil {
				numBucket++
				fmt.Printf("\tKey: %s, Value: %d]\n", node.Key, node.Value)
				node = node.Next
			}
			if maxDepth < numBucket {
				maxDepth = numBucket
			}
		}
	}
	fmt.Printf("MAX Bucket contains %d nodes\n", maxDepth)
}

func isPrime(n int) bool {
	// Corner cases
	if n <= 1 {
		return false
	}
	if n <= 3 {
		return true
	}

	// This is checked so that we can skip middle five numbers in below loop
	if n%2 == 0 || n%3 == 0 {
		return false
	}

	for i := 5; i*i <= n; i = i + 6 {
		if n%i == 0 || n%(i+2) == 0 {
			return false
		}
	}

	return true
}

func nextPrime(n int) int {
	// Base case
	if n <= 1 {
		return 2
	}

	prime := n
	found := false

	// Loop continuously until isPrime returns true for a number greater than n
	for !found {
		prime++
		if isPrime(prime) {
			found = true
		}
	}

	fmt.Printf("Rehash with next capacity of %d.\n", prime)
	return prime
}


////////////////////////////////// TEST FILE //////////////////////////////////////////////////////////
package hashtablell

import (
	"math/rand"
	"testing"
)

var countries = []string{
	"Afghanistan",
	"Albania",
	"Algeria",
	"American Samoa",
	"Andorra",
	"Angola",
	"Anguilla",
	"Antarctica",
	"Antigua and Barbuda",
	"Argentina",
	"Armenia",
	"Aruba",
	"Australia",
	"Austria",
	"Azerbaijan",
	"Bahamas (the)",
	"Bahrain",
	"Bangladesh",
	"Barbados",
	"Belarus",
	"Belgium",
	"Belize",
	"Benin",
	"Bermuda",
	"Bhutan",
	"Bolivia (Plurinational State of)",
	"Bonaire, Sint Eustatius and Saba",
	"Bosnia and Herzegovina",
	"Botswana",
	"Bouvet Island",
	"Brazil",
	"British Indian Ocean Territory (the)",
	"Brunei Darussalam",
	"Bulgaria",
	"Burkina Faso",
	"Burundi",
	"Cabo Verde",
	"Cambodia",
	"Cameroon",
	"Canada",
	"Cayman Islands (the)",
	"Central African Republic (the)",
	"Chad",
	"Chile",
	"China",
	"Christmas Island",
	"Cocos (Keeling) Islands (the)",
	"Colombia",
	"Comoros (the)",
	"Congo (the Democratic Republic of the)",
	"Congo (the)",
	"Cook Islands (the)",
	"Costa Rica",
	"Croatia",
	"Cuba",
	"Curaçao",
	"Cyprus",
	"Czechia",
	"Côte d'Ivoire",
	"Denmark",
	"Djibouti",
	"Dominica",
	"Dominican Republic (the)",
	"Ecuador",
	"Egypt",
	"El Salvador",
	"Equatorial Guinea",
	"Eritrea",
	"Estonia",
	"Eswatini",
	"Ethiopia",
	"Falkland Islands (the) [Malvinas]",
	"Faroe Islands (the)",
	"Fiji",
	"Finland",
	"France",
	"French Guiana",
	"French Polynesia",
	"French Southern Territories (the)",
	"Gabon",
	"Gambia (the)",
	"Georgia",
	"Germany",
	"Ghana",
	"Gibraltar",
	"Greece",
	"Greenland",
	"Grenada",
	"Guadeloupe",
	"Guam",
	"Guatemala",
	"Guernsey",
	"Guinea",
	"Guinea-Bissau",
	"Guyana",
	"Haiti",
	"Heard Island and McDonald Islands",
	"Holy See (the)",
	"Honduras",
	"Hong Kong",
	"Hungary",
	"Iceland",
	"India",
	"Indonesia",
	"Iran (Islamic Republic of)",
	"Iraq",
	"Ireland",
	"Isle of Man",
	"Israel",
	"Italy",
	"Jamaica",
	"Japan",
	"Jersey",
	"Jordan",
	"Kazakhstan",
	"Kenya",
	"Kiribati",
	"Korea (the Democratic People's Republic of)",
	"Korea (the Republic of)",
	"Kuwait",
	"Kyrgyzstan",
	"Lao People's Democratic Republic (the)",
	"Latvia",
	"Lebanon",
	"Lesotho",
	"Liberia",
	"Libya",
	"Liechtenstein",
	"Lithuania",
	"Luxembourg",
	"Macao",
	"Madagascar",
	"Malawi",
	"Malaysia",
	"Maldives",
	"Mali",
	"Malta",
	"Marshall Islands (the)",
	"Martinique",
	"Mauritania",
	"Mauritius",
	"Mayotte",
	"Mexico",
	"Micronesia (Federated States of)",
	"Moldova (the Republic of)",
	"Monaco",
	"Mongolia",
	"Montenegro",
	"Montserrat",
	"Morocco",
	"Mozambique",
	"Myanmar",
	"Namibia",
	"Nauru",
	"Nepal",
	"Netherlands (the)",
	"New Caledonia",
	"New Zealand",
	"Nicaragua",
	"Niger (the)",
	"Nigeria",
	"Niue",
	"Norfolk Island",
	"Northern Mariana Islands (the)",
	"Norway",
	"Oman",
	"Pakistan",
	"Palau",
	"Palestine, State of",
	"Panama",
	"Papua New Guinea",
	"Paraguay",
	"Peru",
	"Philippines (the)",
	"Pitcairn",
	"Poland",
	"Portugal",
	"Puerto Rico",
	"Qatar",
	"Republic of North Macedonia",
	"Romania",
	"Russian Federation (the)",
	"Rwanda",
	"Réunion",
	"Saint Barthélemy",
	"Saint Helena, Ascension and Tristan da Cunha",
	"Saint Kitts and Nevis",
	"Saint Lucia",
	"Saint Martin (French part)",
	"Saint Pierre and Miquelon",
	"Saint Vincent and the Grenadines",
	"Samoa",
	"San Marino",
	"Sao Tome and Principe",
	"Saudi Arabia",
	"Senegal",
	"Serbia",
	"Seychelles",
	"Sierra Leone",
	"Singapore",
	"Sint Maarten (Dutch part)",
	"Slovakia",
	"Slovenia",
	"Solomon Islands",
	"Somalia",
	"South Africa",
	"South Georgia and the South Sandwich Islands",
	"South Sudan",
	"Spain",
	"Sri Lanka",
	"Sudan (the)",
	"Suriname",
	"Svalbard and Jan Mayen",
	"Sweden",
	"Switzerland",
	"Syrian Arab Republic",
	"Taiwan",
	"Tajikistan",
	"Tanzania, United Republic of",
	"Thailand",
	"Timor-Leste",
	"Togo",
	"Tokelau",
	"Tonga",
	"Trinidad and Tobago",
	"Tunisia",
	"Turkey",
	"Turkmenistan",
	"Turks and Caicos Islands (the)",
	"Tuvalu",
	"Uganda",
	"Ukraine",
	"United Arab Emirates (the)",
	"United Kingdom of Great Britain and Northern Ireland (the)",
	"United States Minor Outlying Islands (the)",
	"United States of America (the)",
	"Uruguay",
	"Uzbekistan",
	"Vanuatu",
	"Venezuela (Bolivarian Republic of)",
	"Viet Nam",
	"Virgin Islands (British)",
	"Virgin Islands (U.S.)",
	"Wallis and Futuna",
	"Western Sahara",
	"Yemen",
	"Zambia",
	"Zimbabwe",
	"Åland Islands",
}

func TestAddElements(t *testing.T) {
	ht := HashTableLL{Values: make([]LList, 2), Capacity:2}
	ht.Add("marcio", 10)
	ht.Add("casale", 9)
	ht.Add("souza", 8)
	ht.Add("oicram", 4)
	ht.Add("oicram", 1)
	ht.ToString()
	if ht.Get("marcio") != 10 {
		t.Fatalf("Grade for marcio should be 10, but got %d", ht.Get("marcio"))
	}
}

func TestGetValues(t *testing.T) {
	ht := HashTableLL{Values: make([]LList, 100)}
	ht.Add("marcio", 10)
	ht.Add("casale", 9)
	ht.Add("souza", 8)
	ht.Add("oicram", 4)
	ht.Add("oicram", 1)
	if ht.Get("marcio") != 10 {
		t.Fatalf("Grade for marcio should be 10, but got %d", ht.Get("marcio"))
	}
	if ht.Get("oicram") != 1 {
		t.Fatalf("Grade for marcio should be 1, but got %d", ht.Get("oicram"))
	}
	if ht.Get("luzia") != -1 {
		t.Fatalf("Grade for luzia should be -1, but got %d", ht.Get("luzia"))
	}
}

func TestAddElementsLoadTest(t *testing.T) {
	ht := HashTableLL{Values: make([]LList, 2), Capacity:2}
	ht.Add("Brasil", 10)
	for i:=0; i<300; i++ {
		index := rand.Intn(len(countries) - 1)
		ht.Add(countries[index], index)
		if ht.Get("Brasil") != 10 {
			t.Fatalf("Value for 'Brasil' should be 10, but got %d", ht.Get("Brasil"))
		}
	}
	ht.ToString()
}

func TestDeleteElements(t *testing.T) {
	ht := HashTableLL{Values: make([]LList, 97), Capacity:97}
	for i:=0; i<50; i++ {
		ht.Add(countries[i], i)
	}
	ht.Delete("Chile") // bucket 0 / size 1
	ht.Delete("Cambodia") // bucket 8 / size 2 / delete head
	ht.Delete("Brazil") // bucket 30 / size 3 / delete elem 2 position
	ht.Delete("Bulgaria") // bucket 31 / size 2 / delete last element
	ht.ToString()
}
