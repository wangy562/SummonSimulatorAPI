import os, json, requests, time


class WishItemImporter:

    cwd = os.getcwd()

    def __init__(self):
        self.wish_file_path = self.cwd + "/genshin_wish_data.json"
        self.api_uri = "http://localhost:9000/api/permBanner/addToPool"

    def add_items(self):
        f = open(self.wish_file_path)
        wish_data = json.load(f)
        for i in wish_data:  # each item is a dict
            # Convert item i to json
            requests.post(self.api_uri, json=i)
            item_name = i["name"]
            print(f"posting item {item_name}")
            time.sleep(3)
        f.close()

if __name__ == "__main__":
    wish_item_importer = WishItemImporter()
    wish_item_importer.add_items()
