import os, http, json


class WishItemImporter:

    cwd = os.getcwd()

    def __init__(self):
        self.wish_file_path = self.cwd + "/genshin_wish_data.csv"


if __name__ == "__main__":
    wish_item_importer = WishItemImporter()
